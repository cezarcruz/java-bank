namespace dotnet_bank.Model
{
    public record Account(
        string? Id,
        int Agency
    )
    {
        internal static readonly Account EMPTY = new Account("", -1);
    }
}