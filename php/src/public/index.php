<?php
use \Psr\Http\Message\ServerRequestInterface as Request;
use \Psr\Http\Message\ResponseInterface as Response;

$config['displayErrorDetails'] = true;
$config['addContentLengthHeader'] = false;
$config['db']['host'] = "localhost";
$config['db']['user'] = "adminlogistica";
$config['db']['pass'] = "adminlogistica";
$config['db']['dbname'] = "dblogistica";

require '../vendor/autoload.php';

$app = new \Slim\App(["config" => $config]);
$container = $app->getContainer();

$container['db'] = function ($c) {
    $dbConfig = $c['config']['db'];
    $pdo = new PDO(
        "mysql:host=" . $dbConfig['host'] . ";dbname=" .
            $dbConfig['dbname'],
        $dbConfig['user'],
        $dbConfig['pass']
    );
    $pdo->setAttribute(
        PDO::ATTR_ERRMODE,
        PDO::ERRMODE_EXCEPTION
    );
    $pdo->setAttribute(
        PDO::ATTR_DEFAULT_FETCH_MODE,
        PDO::FETCH_ASSOC
    );
    $db = new NotORM($pdo);
    return $db;
};

$usuarios = $container->db->usuario();
$authUsers = array();

foreach ($usuarios as $usuario) {
    $authUsers[$usuario["usuario"]] = $usuario["senha"];
}

$app->add(new Tuupola\Middleware\HttpBasicAuthentication(
    ["users" => $authUsers]
));

$app->get("/api/entregas/{nome}", function (Request $request, Response
    $response) {
    $nome = $request->getAttribute("nome");
    $response->getBody()->write("Bem vindo a API Basic Auth, $nome");
    return $response;
});

$app->put('/api/entregas/{id}', function (Request $request, Response
    $response) {
    //Atualiza a entrega identificado pelo id
    $body = $request->getParsedBody();
    $idEntrega = $request->getAttribute("id");
    $entrega = $this->db->entregas()->where('id', $idEntrega)->update($body);
    if ($entrega) {
        echo "Entrega atualizada com sucesso";
    } else {
        echo "Entrega não atualizada. Preencha os campos obrigatórios: nome do recebedor, CPF do recebedor, data e hora da entrega";
    }
});

$app->delete('/api/entregas/{id}', function (Request $request, Response $response) {
    //Remove o recurso(entrega) identificado pelo id
    $idEntrega = $request->getAttribute("id");
    $entrega = $this->db->entregas("id = ?", $idEntrega)->delete();
    if ($entrega) {
        echo "Entrega removida com sucesso";
    } else {
        echo "Entrega não removida";
    }
});

$app->run();
?>