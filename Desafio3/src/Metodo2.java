public class Metodo2 {
    public Metodo2() {
    }

    public boolean checkBrackets(Stack<Character> s1) {
        if (s1.isEmpty())
            throw new UnderflowException();

        int countClosedBrackets = 0;

        while (!s1.isEmpty()) {
            char element = s1.pop();

            if (element == ')') {
                countClosedBrackets++;
                continue;
            }

            if (element == '(') {
                if (countClosedBrackets == 0)
                    return false;

                countClosedBrackets--;
            }
        }

        return countClosedBrackets == 0;
    }
}
