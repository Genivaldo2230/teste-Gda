
Entendi, aqui está um exemplo de script SQL para criar uma tabela de vídeos no banco de dados H2:

.sql
Copy code
CREATE TABLE videos (
id VARCHAR(255) PRIMARY KEY,
titulo VARCHAR(255),
descricao VARCHAR(1000),
data_publicacao DATE
);
Este script cria uma tabela chamada "videos" com quatro colunas: "id" (chave primária), "titulo", "descrição"
e "data_publicacao". Você pode alterar o nome e tipo de dados das colunas de acordo com suas necessidades.

Para anúncio

.sql
Copy code
INSERT INTO videos (id, titulo, descricao, data_publicacao)
VALUES ('123456789', 'Titulo do Video', 'Descricao do Video',

'2023-05-04');
Este comando insere um novo registro na tabela "videos" com os valores especificados para as
colunas "id", "titulo", "descrição" e "data_publicacao".

Para remover um vídeo, você pode usar o comando DELETE, como no exemplo abaixo:

.sql
Copy code
DELETE FROM videos WHERE id='123456789';
Este comando remove o registro da tabela "videos" que possui o valor '123456789' na coluna "id".
