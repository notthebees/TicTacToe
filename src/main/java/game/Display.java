package game;

import java.util.Set;

public class Display {

    public void display(Set<Integer> noughts, Set<Integer> crosses) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int pos = i * 3 + j + 1;
                if (noughts.contains(pos)) {
                    builder.append('o');
                } else if (crosses.contains(pos)) {
                    builder.append('x');
                } else {
                    builder.append('.');
                }
            }
            builder.append('\n');
        }
        System.out.println(builder.toString());
    }

}
