````markdown
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
````

## Funcionalidades do CRUD

### Create

Permite cadastrar novos cafés no aplicativo.

### Read

Exibe todos os cafés cadastrados utilizando RecyclerView.

### Update

Possibilita editar informações já registradas.

### Delete

Permite remover cafés cadastrados.

## Campos do Cadastro

Cada café possui:

* Nome
* Método de extração
* Nota
* Descrição
* Tags

## Métodos de Extração Utilizados

Exemplos cadastráveis no aplicativo:

* V60
* Aeropress
* Espresso
* Prensa Francesa
* Chemex
* Cold Brew

## Banco de Dados

O aplicativo utiliza Room Database para armazenamento local dos dados, permitindo persistência mesmo após o fechamento do aplicativo.

## Interface

A interface foi desenvolvida com XML e componentes do Material Design, buscando uma experiência visual simples, organizada e funcional.

## Objetivo do Projeto

O projeto foi desenvolvido com foco em aprendizado prático de desenvolvimento Android nativo, aplicando conceitos importantes como:

* CRUD
* Banco de dados local
* Navegação entre Activities
* RecyclerView
* Arquitetura básica de aplicações Android
* Organização de código

## Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/marianarigueiro/AvaliadorCafe.git
```

2. Abra o projeto no Android Studio.

3. Aguarde a sincronização do Gradle.

4. Execute o aplicativo em um emulador ou dispositivo físico.

## Autor

Mariana Rigueiro

```
```
