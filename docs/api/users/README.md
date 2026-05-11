# Users API

Base URL: `/users`

## Model

| Campo       | Tipo            | Obrigatório | Único | Observação               |
|-------------|-----------------|-------------|-------|--------------------------|
| id          | Long            | auto        | sim   | Gerado automaticamente   |
| name        | String          | sim         | não   | Máx. 120 caracteres      |
| email       | String          | sim         | sim   | Máx. 180 caracteres      |
| password    | String          | sim         | não   | Mín. 6 caracteres        |
| active      | Boolean         | não         | não   | Padrão: `true`           |
| createdAt   | LocalDateTime   | auto        | não   | Preenchido ao criar      |
| updatedAt   | LocalDateTime   | auto        | não   | Preenchido ao atualizar  |

## Endpoints

### Listar usuários

```
GET /users
```

Resposta: `200 OK`

```json
[
  {
    "id": 1,
    "name": "João Silva",
    "email": "joao@email.com",
    "password": "123456",
    "active": true,
    "createdAt": "2026-05-09T15:00:00",
    "updatedAt": null
  }
]
```

---

### Criar usuário

```
POST /users
```

Corpo da requisição:

```json
{
  "name": "João Silva",
  "email": "joao@email.com",
  "password": "123456"
}
```

Resposta: `200 OK`

```json
{
  "id": 1,
  "name": "João Silva",
  "email": "joao@email.com",
  "password": "123456",
  "active": true,
  "createdAt": "2026-05-09T15:00:00",
  "updatedAt": null
}
```

---

### Atualizar parcialmente (PATCH)

```
PATCH /users/{id}
```

Corpo da requisição (campos opcionais):

```json
{
  "name": "João Souza",
  "email": "joao.souza@email.com"
}
```

Resposta: `200 OK`

```json
{
  "id": 1,
  "name": "João Souza",
  "email": "joao.souza@email.com",
  "password": "123456",
  "active": true,
  "createdAt": "2026-05-09T15:00:00",
  "updatedAt": "2026-05-09T16:00:00"
}
```

Erro: `500 Internal Server Error`

```json
{
  "error": "User not found"
}
```

---

### Deletar usuário

```
DELETE /users/{id}
```

Resposta: `200 OK` (sem corpo)
