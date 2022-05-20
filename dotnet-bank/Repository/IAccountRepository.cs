using dotnet_bank.Model;

namespace dotnet_bank.Repository
{
    public interface IAccountRepository
    {
        Account AddAccount(Account account);
        List<Account> GetAccounts();

        Account GetAccount(string? id);
    }
}