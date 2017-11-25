## Trabalho DM107 - Desenvolvimento de Web Services com Segurança sob plataforma Java e PHP

### REST API Serviço de Logística (Entrega)

- *Nota: Todos os recursos são implementados com autenticação Basic Auth.*

- Usuários Autorizados (inseridos no BD pelo script database/dblogistica.sql):

|Usuário   |  Senha |  Senha Base64 Encoded |
| ------------ | ------------ | ------------ |
|  admin | admin  | YWRtaW46YWRtaW4=  |
|  thiago | thiago  |  dGhpYWdvOnRoaWFnbw== |
| daniela  | daniela  | ZGFuaWVsYTpkYW5pZWxh   |

### Recursos
#### Criar Entrega

**- URL:**

http://localhost:8080/TrabalhoLogisticaApi/rest/api/entregas/

**- Method:**
```sh
POST
```

**- Header:**
```sh
Authorization: Basic ZGFuaWVsYWo6ZGFuaWVsYQ==
Content-type: application/json
```
**- URL Params (Required):**
```sh
None
```
**- Body:
**
```sh
{
	"numero_pedido": <numero_pedido>,
	"id_cliente": <id_cliente>,
	"nome_recebedor": "<nome_recebedor>",
	"cpf_recebedor": "<cpf_recebedor>",
	"data_hora_entrega": "<data_hora_entrega>"
}
```
**- Body Required:**
```sh
numero_pedido
id_cliente
```
**Body Example:**
```sh
{
	"numero_pedido": 33,
	"id_cliente": 14,
	"nome_recebedor": "João da Silva",
	"cpf_recebedor": "9876543210",
	"data_hora_entrega": "2017-11-22 15:10:21"
}
```
**- Data Params:**
```sh
None
```
**- Success Response:**

**Code:** 200 OK

**- Error Response:**

**Code:** 401 UNAUTHORIZED 

**- Sample Call:**
```sh
curl -X POST \
  http://localhost:8080/TrabalhoLogisticaApi/rest/api/entregas/ \
  -H 'authorization: Basic YWRtaW46YWRtaW4=' \
  -H 'content-type: application/json' \
  -d '{
	"numero_pedido": 370,
	"id_cliente": 164,
	"nome_recebedor": "Marcos Paulo",
	"cpf_recebedor": "9876543210",
	"data_hora_entrega": "2017-11-22 15:10:21"
}'
```
#### Listar Entrega pelo Número do Pedido

**- URL:**

http://localhost:8080/TrabalhoLogisticaApi/rest/api/entregas/pedidoId/:id

**- Method:**
```sh
GET
```
**- Header:**
```sh
Authorization: Basic ZGFuaWVsYWo6ZGFuaWVsYQ==
Content-type: application/json
```
**- URL Params (Required):**
```sh
id=[integer]
```
**- Data Params:**
```sh
None
```
**- Success Response:**

**Code:** 200 OK
**Response Content:**
```sh
{
    "id": 1,
    "numero_pedido": 10,
    "id_cliente": 1010,
    "nome_recebedor": "Thiago Scodeler",
    "cpf_recebedor": "09678554646",
    "data_hora_entrega": "2017-11-13 02:00:00"
}
```
**- Error Response:**

**Code:** 401 UNAUTHORIZED 

**- Sample Call:**
```sh
curl -X GET \
  http://localhost:8080/TrabalhoLogisticaApi/rest/api/entregas/pedidoId/10 \
  -H 'authorization: Basic ZGFuaWVsYTpkYW5pZWxh' \
  -H 'content-type: application/json'
```
#### Atualizar Entrega pelo ID da Entrega

**- URL:**

http://localhost/dm107/trabalhologisticaapi/DM107/php/src/public/api/entregas/:id

**- Method:**
```sh
PUT
```
**- Header:**
```sh
Authorization: Basic ZGFuaWVsYWo6ZGFuaWVsYQ==
Content-type: application/json
```
**- URL Params (Required):**
```sh
id=[integer]
```
**- Body:**
```sh
{
	"numero_pedido": <numero_pedido>,
	"id_cliente": <id_cliente>,
	"nome_recebedor": "<nome_recebedor>",
	"cpf_recebedor": "<cpf_recebedor>",
	"data_hora_entrega": "<data_hora_entrega>"
}
```
**- Body Required:**
```sh
nome_recebedor
cpf_recebedor
data_hora_entrega
```
**- Body Example:**
```sh
{
	"numero_pedido": 99,
	"id_cliente": 51,
	"nome_recebedor": "Emilio Silva",
	"cpf_recebedor": "1234568",
	"data_hora_entrega": "2016-10-20 12:10:21"
}
```
**- Data Params**:
```sh
None
```
**- Success Response:**

**Code:** 200 OK
**Response Content:** "Entrega atualizada com sucesso"

OR

**Code:** 200 OK
**Response Content:** "Entrega não atualizada. Preencha os campos obrigatórios: nome do recebedor, CPF do recebedor, data e hora da entrega"

**- Error Response:**

**Code:** 401 UNAUTHORIZED 

**- Sample Call:**
```sh
curl -X PUT \
  http://localhost/dm107/trabalhologisticaapi/DM107/php/src/public/api/entregas/5 \
  -H 'authorization: Basic ZGFuaWVsYTpkYW5pZWxh' \
  -H 'content-type: application/json' \
  -d '{
	"numero_pedido": 99,
	"id_cliente": 51,
	"nome_recebedor": "Emilio Silva",
	"cpf_recebedor": "1234568",
	"data_hora_entrega": "2016-10-20 12:10:21"
}'
```

#### Deletar Entrega pelo ID da Entrega

**- URL:**

http://localhost/dm107/trabalhologisticaapi/DM107/php/src/public/api/entregas/:id

**- Method:**
```sh
DELETE
```
**- Header:**
```sh
Authorization: Basic ZGFuaWVsYWo6ZGFuaWVsYQ==
Content-type: application/json
```
**- URL Params (Required):**
```sh
id=[integer]
```
**- Data Params:**
```sh
None
```
**- Success Response:**

**Code:** 200 OK
**Response Content:** "Entrega removida com sucesso"

OR

**Code:** 200 OK
**Response Content:** "Entrega não removida"

**- Error Response:**

**Code:** 401 UNAUTHORIZED 

**- Sample Call:**
```sh
curl -X DELETE \
  http://localhost/dm107/trabalhologisticaapi/DM107/php/src/public/api/entregas/12 \
  -H 'authorization: Basic ZGFuaWVsYTpkYW5pZWxh' \
  -H 'content-type: application/json'
```