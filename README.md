# Avaliador de Cafés

Aplicativo Android desenvolvido em Kotlin com o objetivo de registrar, avaliar e organizar cafés com base em métodos de extração, notas e características sensoriais.

O projeto foi desenvolvido utilizando Android Studio, RecyclerView e Room Database, aplicando conceitos de CRUD completo, organização em camadas e interface gráfica com Material Design.

## Funcionalidades

- Cadastro de cafés
- Listagem de cafés cadastrados
- Atualização de informações
- Exclusão de cafés
- Sistema de notas
- Registro de métodos de extração
- Organização por tags
- Persistência de dados com Room Database
- Interface simples e intuitiva

## Tecnologias Utilizadas

- Kotlin
- Android Studio
- XML
- RecyclerView
- Room Database
- ViewBinding
- Material Design
- SQLite

## Estrutura do Projeto

```text
com.example.avaliadorcafe
│
├── adapter
│   └── CafeAdapter.kt
│
├── data
│   ├── AppDatabase.kt
│   └── CafeDao.kt
│
├── model
│   └── Cafe.kt
│
├── CadastroActivity.kt
├── MainActivity.kt
│
└── res
    ├── layout
    │   ├── activity_main.xml
    │   ├── activity_cadastro.xml
    │   └── item_cafe.xml
