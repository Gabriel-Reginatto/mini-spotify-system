🎧 Mini Spotify System

Mini Spotify System é uma aplicação Java de console que simula um sistema de streaming de mídias sonoras, inspirado em plataformas como o Spotify.
O projeto foi desenvolvido com foco em boas práticas de Programação Orientada a Objetos, organização de código e versionamento com Git.

📌 Visão Geral

O sistema permite que usuários interajam com um catálogo de mídias (músicas, podcasts e audiobooks), criem playlists personalizadas e gerenciem suas mídias de forma simples e intuitiva por meio de menus no console.

Este projeto tem caráter educacional, porém segue padrões próximos aos utilizados em aplicações reais.

✨ Funcionalidades
Usuário

Criação e gerenciamento de playlists

Listagem de playlists cadastradas

Adição e remoção de mídias em playlists

Cálculo automático da duração total de uma playlist

Catálogo de Mídias

Armazenamento centralizado de mídias

Listagem completa do catálogo

Pesquisa flexível por:

Título

Criador (artista/autor)

Gênero

Playlists

Associação a um único usuário

Prevenção de duplicação de mídias

Cálculo dinâmico de duração total

🛠️ Arquitetura e estrutura

A arquitetura segue o princípio de separação de responsabilidades, onde:

model contém as regras de negócio

system gerencia usuários e validações

menu é responsável apenas pela interação com o usuário

Main apenas inicializa e conecta os componentes

🛠️ Tecnologias e Ferramentas

Java

Java Collections Framework

Streams API

Exceções personalizadas

Git & GitHub

IntelliJ IDEA

🧠 Conceitos Aplicados

Programação Orientada a Objetos (POO)

Encapsulamento

Herança

Polimorfismo

Abstração

Clean Code

Refatoração incremental

Organização em camadas

Versionamento de código com Git

▶️ Execução do Projeto

Clone o repositório:

git clone https://github.com/seu-usuario/mini-spotify-system.git


Abra o projeto no IntelliJ IDEA

Execute a classe:

Main.java


Utilize o menu interativo no console para testar as funcionalidades

🧪 Dados de Teste

O projeto inicia com um catálogo previamente populado no Main, permitindo testar todas as funcionalidades sem necessidade de cadastro manual de mídias.

📈 Melhorias Futuras

Autenticação com senha

Persistência de dados (arquivo ou banco de dados)

Interface gráfica (JavaFX ou Web)

Ordenação e filtros avançados de playlists

Sistema de favoritos e histórico de reprodução

👨‍💻 Autor

Gabriel Reginatto
Projeto desenvolvido para estudo e prática de Java e POO.
