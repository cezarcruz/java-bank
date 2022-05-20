using dotnet_bank.Model;
using Microsoft.AspNetCore.Mvc;
using dotnet_bank.Repository;

namespace dotnet_bank.Controllers
{
    [ApiController]
    [Route("account")]
    public class AccountController : ControllerBase
    {
        private readonly IAccountRepository _accountRepository;

        public AccountController(IAccountRepository accountRepository)
        {
            _accountRepository = accountRepository;
        }

        [HttpGet]
        public IActionResult Get()
        {
            return Ok(_accountRepository.GetAccounts());
        }

        [HttpPost]
        public IActionResult Post(Account account)
        {
            var createdAccount = _accountRepository.AddAccount(account);

            var accountUrl = $"/account/{createdAccount.Id}";

            return Created(accountUrl, createdAccount);
        }

        [HttpGet]
        [Route("/{id?}")]
        public IActionResult Get(string? id) {
            return Ok(_accountRepository.GetAccount(id));
        }
    }
}