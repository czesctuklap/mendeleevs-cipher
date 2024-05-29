import java.util.*;

public class Cipher
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("\nPodaj tekst, który chcesz zaszyfrować zgodnie z szyfrem Mendelejewa - zamiast kolejnych liter, wypisywane są liczby atomowe pierwiastka,\n"
                + "odstęp między literami zastępuje symbol gwiazdki *, a odstęp miedzy wyrazami dwie gwiazdki **.\n"
                + "Zaszyfrowane nie mogą zostać znaki specjalne typu !,*,# ani liczby, ponieważ mogłoby to wprowadzić błędy związane z odczytem zaszyfrowanego tekstu.\n");

        System.out.print("Tekst do zaszyfrowania: ");
        String text = in.nextLine();

        check(text);

    }

    static String mendeleevCipher(String input) throws Exception
    {
        Map<String, Integer> elements = new HashMap<>();

        elements.put("H",1); elements.put("HE",2); elements.put("LI",3); elements.put("BE",4); elements.put("B",5); elements.put("C", 6);
        elements.put("N", 7); elements.put("O", 8); elements.put("F", 9); elements.put("NE", 10); elements.put("NA", 11); elements.put("MG", 12);
        elements.put("AL", 13); elements.put("SI", 14); elements.put("P", 15); elements.put("S", 16); elements.put("CL", 17); elements.put("AR", 18);
        elements.put("K", 19); elements.put("CA", 20); elements.put("SC", 21); elements.put("TI", 22); elements.put("V", 23); elements.put("CR", 24);
        elements.put("MN", 25); elements.put("FE", 26); elements.put("CO", 27); elements.put("NI", 28); elements.put("CU", 29); elements.put("ZN", 30);
        elements.put("GA", 31); elements.put("GE", 32); elements.put("AS", 33); elements.put("SE", 34); elements.put("BR", 35); elements.put("KR", 36);
        elements.put("RB", 37); elements.put("SR", 38); elements.put("Y", 39); elements.put("ZR", 40); elements.put("NB", 41); elements.put("MO", 42);
        elements.put("TC", 43); elements.put("RU", 44); elements.put("RH", 45); elements.put("PD", 46); elements.put("AG", 47); elements.put("CD", 48);
        elements.put("IN", 49); elements.put("SN", 50); elements.put("SB", 51); elements.put("TE", 52); elements.put("I", 53); elements.put("XE", 54);
        elements.put("CS", 55); elements.put("BA", 56); elements.put("LA", 57); elements.put("CE", 58); elements.put("PR", 59); elements.put("ND", 60);
        elements.put("PM", 61); elements.put("SM", 62); elements.put("EU", 63); elements.put("GD", 64); elements.put("TB", 65); elements.put("DY", 66);
        elements.put("HO", 67); elements.put("ER", 68); elements.put("TM", 69); elements.put("YB", 70); elements.put("LU", 71); elements.put("HF", 72);
        elements.put("TA", 73); elements.put("W", 74); elements.put("RE", 75); elements.put("OS", 76); elements.put("IR", 77); elements.put("PT", 78);
        elements.put("AU", 79); elements.put("HG", 80); elements.put("TL", 81); elements.put("PB", 82); elements.put("BI", 83); elements.put("PO", 84);
        elements.put("AT", 85); elements.put("RN", 86); elements.put("FR", 87); elements.put("RA", 88); elements.put("AC", 89); elements.put("TH", 90);
        elements.put("PA", 91); elements.put("U", 92); elements.put("NP", 93); elements.put("PU", 94); elements.put("AM", 95); elements.put("CM", 96);
        elements.put("BK", 97); elements.put("CF", 98); elements.put("ES", 99); elements.put("FM", 100); elements.put("MD", 101); elements.put("NO", 102);
        elements.put("LR", 103); elements.put("RF", 104); elements.put("DB", 105); elements.put("SG", 106); elements.put("BH", 107); elements.put("HS", 108);
        elements.put("MT", 109); elements.put("DS", 110); elements.put("RG", 111); elements.put("CN", 112); elements.put("NH", 113); elements.put("FL", 114);
        elements.put("MC", 115); elements.put("LV", 116); elements.put("TS", 117); elements.put("OG", 118);

        char[] sentence = input.toUpperCase().toCharArray();
        ArrayList<String> ciphered = new ArrayList<>();
        String output = "";

        for (int i = 0; i < sentence.length; i++)
        {
            if (Character.isLetter(sentence[i]))
            {
                String pair = "  ";

                if (i + 1 < sentence.length) pair = String.valueOf(sentence[i]) + String.valueOf(sentence[i+1]);

                if (elements.containsKey(pair))
                {
                    for (Map.Entry<String, Integer> entry : elements.entrySet())
                    {
                        if (entry.getKey().equals(pair))
                        {
                            ciphered.add(entry.getValue().toString());
                            break;
                        }
                    }

                    if (i + 2 == sentence.length) break;

                    else
                    {
                        ciphered.add("*");
                        i++;
                    }
                }

                else
                {
                    if (elements.containsKey(String.valueOf(sentence[i])))
                    {
                        for (Map.Entry<String, Integer> entry : elements.entrySet())
                        {
                            if (entry.getKey().equals(String.valueOf(sentence[i])))
                            {
                                ciphered.add(entry.getValue().toString());
                                break;
                            }
                        }

                        if (i+1==sentence.length) break;

                        else ciphered.add("*");
                    }

                    else throw new Exception();
                }
            }

            else if (sentence[i] == ' ') ciphered.add("*");

            else
            {
                System.out.println("Wprowadzono nieobsługiwane znaki");
                throw new Exception();
            }
        }

        for (String element : ciphered)
        {
            output += element;
        }

        return output;
    }

    static void check(String text)
    {
        try
        {
            String output = mendeleevCipher(text);
            System.out.println("Zaszyfrowany tekst: " + output);
        }
        catch (Exception e)
        {
            System.out.println("Nie można zaszyfrować podanego tekstu");
        }
    }
}
