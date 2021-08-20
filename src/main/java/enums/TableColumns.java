package enums;

public enum TableColumns {
    FirstName(0),
    LastName(1),
    Email(2),
    Due(3),
    WebSite(4),
    Action(5);

    public int indexOfColumn;

    private TableColumns(int indexOfColumn) {
        this.indexOfColumn = indexOfColumn;
    }
}
