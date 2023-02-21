package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * [9/01/2012] Challenge #94 [easy] (Elemental symbols in strings)
 * <p>
 * If you've ever seen Breaking Bad, you might have noticed how some names in the opening credit sequence get highlights
 * according to symbols of elements in the periodic table. Given a string as input, output every possible such
 * modification with the element symbol enclosed in brackets and capitalized. The elements can appear anywhere in the
 * string, but you must only highlight one element per line, like this:
 * <p>
 * $ ./highlight dailyprogrammer
 * dailypr[O]grammer
 * daily[P]rogrammer
 * dail[Y]programmer
 * da[I]lyprogrammer
 * dailyprog[Ra]mmer
 * daily[Pr]ogrammer
 * dailyprogramm[Er]
 * dailyprogr[Am]mer
 */
public class Challenge94 {

    private static final List<String> SYMBOLS = List.of(
            "Ac", "Ag", "Al", "Am", "Ar", "As", "At", "Au", "B", "Ba", "Be", "Bh", "Bi",
            "Bk", "Br", "C", "Ca", "Cd", "Ce", "Cf", "Cl", "Cm", "Cn", "Co", "Cr", "Cs",
            "Cu", "Db", "Ds", "Dy", "Er", "Es", "Eu", "F", "Fe", "Fl", "Fm", "Fr", "Ga",
            "Gd", "Ge", "H", "He", "Hf", "Hg", "Ho", "Hs", "I", "In", "Ir", "K", "Kr", "La",
            "Li", "Lr", "Lu", "Lv", "Md", "Mg", "Mn", "Mo", "Mt", "N", "Na", "Nb", "Nd", "Ne",
            "Ni", "No", "Np", "O", "Os", "P", "Pa", "Pb", "Pd", "Pm", "Po", "Pr", "Pt", "Pu",
            "Ra", "Rb", "Re", "Rf", "Rg", "Rh", "Rn", "Ru", "S", "Sb", "Sc", "Se", "Sg", "Si", "Sm",
            "Sn", "Sr", "Ta", "Tb", "Tc", "Te", "Th", "Ti", "Tl", "Tm", "U", "Uuo", "Uup", "Uus", "Uut",
            "V", "W", "Xe", "Y", "Yb", "Zn", "Zr"
    );

    private List<String> charactersOfString(String word) {
        List<String> characters = new ArrayList<>();
        for (char ch : word.toCharArray()) {
            characters.add(String.valueOf(ch).toUpperCase());
        }
        return characters;
    }

    private void highlight(String word) {
        List<String> characters = charactersOfString(word);
        for (int i = 0; i < characters.size(); i++) {
            for (int k = 0; k < SYMBOLS.size(); k++) {
                String currentChar = characters.get(i);
                String symbol = SYMBOLS.get(k);

                String formatted = i > 0 ? word.substring(0, i) : "";
                formatted += "[" + symbol + "]";

                if (currentChar.equalsIgnoreCase(symbol)) {
                    formatted += i + 1 < word.length() ? word.substring(i + 1) : "";
                    System.out.println(formatted);
                }

                if (i + 1 < word.length()) {
                    if ((currentChar + characters.get(i + 1)).equalsIgnoreCase(symbol)) {
                        formatted += i + 1 < word.length() ? word.substring(i + 2) : "";
                        System.out.println(formatted);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Challenge94 challenge94 = new Challenge94();

        challenge94.highlight("dailyprogrammer");
    }

}
