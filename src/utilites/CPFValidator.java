package utilites;

public class CPFValidator {
    public static boolean verificar(String cpf) {
        if (cpf.length() != 11) {
            return false;
        }

        int firstDigit = calculateFirstDigit(cpf);
        int secondDigit = calculateSecondDigit(cpf, firstDigit);

        return cpf.charAt(9) == firstDigit + '0' && cpf.charAt(10) == secondDigit + '0';
    }

    private static int calculateFirstDigit(String cpf) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * (10 - i);
        }

        int result = 11 - (sum % 11);
        if (result > 9) {
            result = 0;
        }

        return result;
    }

    private static int calculateSecondDigit(String cpf, int firstDigit) {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * (11 - i);
        }

        int result = 11 - (sum % 11);
        if (result > 9) {
            result = 0;
        }

        return result;
    }
}