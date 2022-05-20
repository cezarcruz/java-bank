using dotnet_bank.Model;

namespace dotnet_bank.Repository
{
    public class AccountRepository : IAccountRepository
    {
        private HashSet<Account> _accounts = new HashSet<Account>();

        public Account AddAccount(Account account)
        {
            var accoutWithId = account with { Id = Guid.NewGuid().ToString() };
            _accounts.Add(accoutWithId);
            return accoutWithId;
        }

        public Account GetAccount(string? id)
        {
            //TODO: nhack
            if (id == null) {
                return Account.EMPTY;
            }

            return _accounts.Where(account => account.Id == id).FirstOrDefault(Account.EMPTY);
        }

        public List<Account> GetAccounts()
        {
            //TODO: nhack
            return _accounts.ToList();
        }
    }
}