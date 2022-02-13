package enums;

public enum ColumnNumber {
    NAME(1),
    QTY(2),
    VIEWED(3),
    CREATED(4),
    DIRECTLINK(5),
    DELETE(6);

    public final int columnNumber;

    ColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }
}


