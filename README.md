# Petshop
### Sistema de um petshop com integração ao banco de dados e organização MVC. Este foi o meu primeiro sostema utilizando o Springboot; nele é possível cadastrar usuários, pets de cada usuário, a raça e a espécie do pet (utilizando relacionamentos no banco), produtos e fazer pagamento em boletos. (a área de boletos ainda está em andamento)

# Diagrama de Entidade e Relacionamento
Esse é o diagrama do banco de dados utilizado nesse sistema. As tabelas possuem vários relacionamentos complexos entre si.

<img align="center" alt="index" height="1080px" width="800px" src="./img/db.png">

# Imagens da Interface
Aqui estará as imagens da interface do site, tentando mostrar como funciona cada área.

## Index
A aba inicial do site trabalha juntamente com a parte de produtos. Todos os produtos listados no banco (até com suas imagens sendo pegas pelo path) são colocados nessa parte, formando um grid.

<img align="center" alt="index" height="1080px" width="800px" src="./img/index.png">

#

## Fragmento Sidebar
Esta side bar é um fragmento (arquivo html a parte) que está presente em todo o site, por ser um arquivo a parte não é necessário atualizar outras sidebars, já que são uma só fragmentada pelo site. 

<img align="center" alt="index" height="1080px" width="800px" src="./img/sidebar.png">

#

## CRUD e Formas de Pagamento
Utilizei dessa parte em específico para demonstrar o CRUD funcional do banco de dados. Essa aba serve para adicionar uma forma de pagamento específica que pode ser chamada como uma chave estrangeira quando o usuário for pagar. A primeira imagem logo abaixo é antes de qualquer alteração para a demonstração do CRUD.

<img align="center" alt="index" height="1080px" width="800px" src="./img/forma de pagamento.png">

### Cadastrar (Create)
Aqui está sendo criado a forma com id 5 (cheque)

<img align="center" alt="index" height="1080px" width="800px" src="./img/cadastro forma.png">

### Ler (Read)
Após a criação é mostrado a nova forma de pagamento no final da tabela

<img align="center" alt="index" height="1080px" width="800px" src="./img/forma cadastrada.png">

### Editar (Update)
A primeira imagem é a tela do formulário de editar, onde puxa as informações da linha pelo ID. A segunda foto é após a edição, mostrando que a forma com ID 4 mudou de "crédito" para "dinheiro".

<img align="center" alt="index" height="1080px" width="800px" src="./img/forma editar.png">
<img align="center" alt="index" height="1080px" width="800px" src="./img/forma editar2.png">

### Deletar (Delete)
Ainda na listagem é possível excluir alguma linha da tabela, onde será apagada do banco de dados. A primeira imagem mostra o aviso ao clicar com o botão de excluir. A segunda imagem mostra o resultado do delete.

<img align="center" alt="index" height="1080px" width="800px" src="./img/forma deletada.png">
<img align="center" alt="index" height="1080px" width="800px" src="./img/forma deletada2.png">
