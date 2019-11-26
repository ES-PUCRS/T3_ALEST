# Trabalho final de P.O.O. 1/2019
Trabalho final da disciplina de programação orientada a objetos
ministrado pelo professor Bernardo Copstein

# Chess_TF
## Objetivo geral
O obejtivo deste trabalho é explorar os conceitos de programação orientada a objetos em especial herança e polimorfismo. Conceitos de programação orientada a eventos também são explorados na medida que a interface com o usuário também deve ser ampliada a modificada. Durante o desenvolvimento do trabalho final, foi procurado a utilização de todos os conhecimentos ofertados na cadeira de P.O.O. como Lambda, Orientado à objeto, Try, Catch, --Finally, Throw, classes singleton, Comparable e Collections.


## Regras do Jogo
Peão (Pawn) = Como primeiro movimento o mesmo pode se mover em até duas casas caso não haja ninguém em seu caminho. Seu ataque apenas acontece uma casa à frente nas diagonais, nunca diretamente à frente. O peão também pode assumir qualquer outra peça -com excessão do rei- após alcançar o limite do tabuleiro;
Torre (Rook) = Apenas se movimenta entre colunas ou entre linhas, jamais os dois juntos, também não pode se mover caso outra peça esteja no seu caminho;
Cavalo (Knight) = Move-se por duas colunas e uma linha ou o inverso, não se afetando ter outra peça em seu caminho;
Bispo (Bishop) = Move-se paralelamente igual entre linhas e colunas, não podendo ter outra peça em seu caminho;
Rainha (Queen) = Seu movimento é caracterizado pelo Bispo e pela Torre, podendo assumir qualquer um dos dois; 
Rei (King) = A peça mais importante do jogo, caso derrotada, o jogador perde. A mesma não pode assumir uma posição que lhe deixe a menos de um bloco de distância do rei inimigo.
* Movimentos especiais como Rock não estão implementados nesse jogo *


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
1. Entre no diretório do projeto;
2. Abra o terminal;
3. Compile o projeto utilizando o comando "javac *.java";
4. Para rodar o projeto utilize o comando "java UX".
