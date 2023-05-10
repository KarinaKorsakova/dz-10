public class Main {

    public static void main(String[] args) {
        BankApplication bankApplication = new BankApplication();

        try {

            bankApplication.process("accountId000", 100, "USD");
        } catch (WrongAccountException wrongAccountException) {
            System.out.println("Такого акаунту не існує");
        } catch (WrongCurrencyException wrongCurrencyException) {
            System.out.println("Акаунт має рахунок в іншій валюті");
        } catch (WrongOperationException wrongOperationException) {
            System.out.println("Акаунт не має достатньо коштів");
        } catch (Exception e) {
            System.out.println("Сталася помилка при процесінгу, спробуйте ще раз");
        } finally {
            System.out.println("Дякуємо, що скористалися нашим сервісом");
        }
    }
}
