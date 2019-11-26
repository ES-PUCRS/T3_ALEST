# T3 de Algoritmos e Estruturas de Dados 2/2019
Terceiro trabalho da disciplina Algoritmos e Estrutura de Dados
ministrado pela professora Isabel Manshour

# Árvore Rubro-Negra
## Objetivo geral
O obejtivo deste trabalho é explorar os conceitos de estruturas de dados, especialmente o relacionado a árvores

programação orientada a objetos em especial herança e polimorfismo. Conceitos de programação orientada a eventos também são explorados na medida que a interface com o usuário também deve ser ampliada a modificada. Durante o desenvolvimento do trabalho final, foi procurado a utilização de todos os conhecimentos ofertados na cadeira de P.O.O. como Lambda, Orientado à objeto, Try, Catch, --Finally, Throw, classes singleton,

## Estrutura do projeto
UI = User Interface = Principalmente estruturada para a execução do GUI, sendo a mesma uma tela predominantemente branca desenvolvida em JavaFX, tendo seu lado esquerda um painel designado ao controle da árvore e o centro/lado direito respectivamente direcionados à exibição visual didática da construção da Árvore Rubro-Negra;
Algorithms = package das estruturas de dados utilizadas no projeto, contendo:
* datastructures;
	* LinkedListOfInteger;
	* LinkedList;
	* Queue.
* Tree.
Those 

## Estrutura de classes
O diagrama de classes pode ser encontrado junto a este arquivo.
- Images: Carrega e salva todas as imagens que serão utilizadas em um HashMap;
- Picture: Extensão de Images capás de carregar uma única imagem e retornar Image ou ImageView;
- ExceptionHandler: Utilizado pela classe Board, implementa a classe Thread.UncaughtExceptionHandler. É utilizado como um filtro capturando excessões que não foram devidamente direcionadas para a classe ScreenGx e acabaram em uma thread de setOnAction;
- AlertList: Classe que mantem todos os Alerts gerados durante o jogo sendo ativada por Throw. Extende a classe ScreenGx para obtenção de informações;
- ScreenGx: Classe responsável pelo GUI(UI/UX) do projeto, essa classe cria todas as telas que serão utilizadas.(Classe Singleton);
- UX: Carrega os estágios que serão utilizados pela aplicação. Extende Application e carrega o método Main;
- Game: Responsável por coordenar todo o jogo, organizar turnos e jogadas inválidas. (Classe Singleton);
- BoardSquare: Extensão de Button, carrega a sua posição e a peça presente. Também é responsável pela apresentação gráfica da imagem no tabuleiro, sendo cada campo do tabuleiro um BoardSquare, torna-se o respectivo Button com a imagem da peça em suas coordenadas;
- Coordinate: Classe responsável pela coordenação das coordenadas do tabuleiro, utilizada para validação de movimento e aferição de posição;
- Board: Extensão de GridPane, carrega no seu Grid todas as ((Buttons)BoardSquare) do jogo, também é responsável por atualizar a classe Game com as novas posições das peças;
- Team: Classe ENUM, carrega os times das peças (White, Black, None);
- Chessman: Classe abstrata com os métodos necessários a serem implementados para cada peça;
- ChessmanDefault: Classe parcialmente abstrata que modela métodos padrões para todas as peças;
- Pawn: Estende ChessmanDefault. Também chama a classe Class para criar a tela de troca de peça;
- King: Estende ChessmanDefault;
- Movements: Classe Abstrata que estende ChessmanDefault e sobrescreve os métodos de movimento padrões para Rainha, Bispo e Torre;
- Rainha, Bispo, Torre: Estendem Movements, indicam para onde deve ser testado e aponta valor "p" do calculo para a classe pai. *Valor "P" presente em comentário acima do método tryMove na classe Moviments*


## Instruções para compilar e executar o projeto
1. Baixe o projeto (aqui)["link"], ou clone-o por aqui: 
1.1. Caso tenha optado por baixar, será necessário descompactar o projeto. 
2. Abra a pasta /src/commands presente no projeto
3. Execute o arquivo Build.bat. Ele é responsável por buildar o projeto criando os arquivos .class
4. Agora rode o arquivo Compile.bat. Esse arquivo irá executar o projeto Java.

//'till dev (:
3. Execute o arquivo Run.bat. Esse arquivo é responsável por gerenciar os backups e buildar o projeto.