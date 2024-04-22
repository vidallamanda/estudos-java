public class Main {
    public static void main(String[] args) {
        // Teste do Método 1
        // Teste 1: Tipo Integer e elemento existe na lista
        StaticList<Integer> lista1 = new StaticList<>(20);
        lista1.insert(1, 0);
        lista1.insert(2, 1);
        lista1.insert(3, 2);
        lista1.insert(1, 3);
        System.out.println("Quantidade de vezes o elemento aparece na lista: " + lista1.contaElementos(1));

        // Teste 2: Tipo String e elemento existe na lista
        StaticList<String> lista2 = new StaticList<>(20);
        lista2.insert("Desodorante", 0);
        lista2.insert("Sabonete", 1);
        lista2.insert("Esponja", 2);
        lista2.insert("Escova", 3);
        System.out.println("Quantidade de vezes que o elemento aparece na lista: " + lista2.contaElementos("Esponja"));

        // Teste do Método 2
        Metodo2 metodo2 = new Metodo2();

        // Teste 1: Expressão correta
        StaticStack<Character> expressao1 = new StaticStack<>(20);
        expressao1.push('(');
        expressao1.push('(');
        expressao1.push('A');
        expressao1.push('+');
        expressao1.push('B');
        expressao1.push(')');
        expressao1.push('-');
        expressao1.push('(');
        expressao1.push('C');
        expressao1.push('+');
        expressao1.push('D');
        expressao1.push(')');
        expressao1.push(')');
        System.out.println("Expressão 1 está correta? " + (metodo2.checkBrackets(expressao1) ? "sim" : "não"));

        // Teste 2: Expressão com número desigual de parênteses
        StaticStack<Character> expressao2 = new StaticStack<>(10);
        expressao2.push('(');
        expressao2.push('A');
        expressao2.push('+');
        expressao2.push('B');
        expressao2.push(')');
        expressao2.push('(');
        expressao2.push(')');
        expressao2.push(')');
        System.out.println("Expressão 2 está correta? " + (metodo2.checkBrackets(expressao2) ? "sim" : "não"));

        // Teste 3: Expressão com parênteses fechados antes de serem abertos
        StaticStack<Character> expressao3 = new StaticStack<>(10);
        expressao3.push(')');
        expressao3.push('A');
        expressao3.push('+');
        expressao3.push('B');
        expressao3.push('(');
        System.out.println("Expressão 3 está correta? " + (metodo2.checkBrackets(expressao3) ? "sim" : "não"));

        // Teste 4: Expressão com parênteses abertos sem fechamento
        StaticStack<Character> expressao4 = new StaticStack<>(10);
        expressao4.push('(');
        expressao4.push('A');
        expressao4.push('+');
        expressao4.push('B');
        expressao4.push('(');
        System.out.println("Expressão 4 está correta? " + (metodo2.checkBrackets(expressao4) ? "sim" : "não"));

    }
}