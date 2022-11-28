# **HACKATHON - [Webible](https://www.abibliadigital.com.br/)**

## Sobre:

Este e um aplicativo de leitura da bíblia, com o intuito de ser possível a leitura do livro, mesmo sem possuir o livro físico.

## Suporte:

Atualmente o aplicativo esta presente nas plataformas Android (+5.0) e [navegadores](https://github.com/CarolAguera/app-webible).

## Projeto

### Estrutura de arquivos:

```jsx
src
└── main
    ├── AndroidManifest.xml // Configurações globais do Android
    ├── java
    │   ├── adapters
    │   │   ├── // Adapters utilizados para trabalhar com ListView and GridView
    │   ├── aguiar
    │   │   └── fedechen
    │   │       └── flavio
    │   │           └── mobible
    │   │               └── // Classes Java Files com as implementações das Actions
    │   ├── Config
    │   │   └── // Configurações utilizadas no projeto
    │   ├── dtos
    │   │   └── // Classes DTO's
    │   ├── services
    │   │   └── // Classes de Serviços externos (API)
    │   └── utils
    │       └── // Utiliztarios do projeto
    └── res
        ├── drawable
        │   └── // Imagens do projeto
        ├── layout
        │   ├── // Arquivos Xml com layout das Activity
        └── values
            └── // Configurações de cores e temas
```

### Layout do App:

![WhatsApp Image 2022-11-28 at 18.19.13.jpeg](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/3607134c-b7d7-4fb2-a0f9-0258242799e6/WhatsApp_Image_2022-11-28_at_18.19.13.jpeg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221128%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221128T213214Z&X-Amz-Expires=86400&X-Amz-Signature=3f2406e32b5b07d498dfed93b130db1af88716623e20c8ea7e60e8bf0ffa267e&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22WhatsApp%2520Image%25202022-11-28%2520at%252018.19.13.jpeg%22&x-id=GetObject)

Listagem de Livros

![WhatsApp Image 2022-11-28 at 18.19.14.jpeg](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/7c32f218-664b-4fb6-9b2b-816c7476bcd6/WhatsApp_Image_2022-11-28_at_18.19.14.jpeg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221128%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221128T213235Z&X-Amz-Expires=86400&X-Amz-Signature=811b4851cc9d918f5d4b168b62012e85ce227df9a6b59558bc072fff2b55ba13&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22WhatsApp%2520Image%25202022-11-28%2520at%252018.19.14.jpeg%22&x-id=GetObject)

Listagem de Capitulos

![WhatsApp Image 2022-11-28 at 18.19.14 (1).jpeg](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/9cc9ddd7-824d-452a-9a2d-e3b0a8545eee/WhatsApp_Image_2022-11-28_at_18.19.14_%281%29.jpeg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221128%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221128T213250Z&X-Amz-Expires=86400&X-Amz-Signature=4fd95161784de10513dfad45fead6a0517f4451e8bc7c7d1c98e12fd837a77a1&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22WhatsApp%2520Image%25202022-11-28%2520at%252018.19.14%2520%281%29.jpeg%22&x-id=GetObject)

Texto referente ao Capitulo

### Run App:

- Abra o projeto no Android Studio

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/886aa36e-dc11-4b19-ae1f-685d68ee0afc/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221128%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221128T213310Z&X-Amz-Expires=86400&X-Amz-Signature=c2e40ddb29c178952248779a4b9588761e8e2548bc05cc42d5b928800d122b50&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)