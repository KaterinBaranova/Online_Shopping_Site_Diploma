package enums;

public enum ColumnName {
    PRODUCT("cart_product"),
    DESCRIPTION("cart_description"),
    AVAIL("cart_avail"),
    UNITPRICE("cart_unit"),
    QTY("cart_quantity"),
    TOTAL("cart_total"),
    DELETE("cart_delete");

    public final String columnName;

    ColumnName(String columnName) {
        this.columnName = columnName;
    }
}

