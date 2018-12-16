package Locators;

public interface BasketPageLocators {
    String ITEMS_QUANTITY_FIELD_ID = "id_form-0-quantity";
    String DELETE_BUTTON_CSS = ".remove";
    String CHECKOUT_BUTTON_CSS = "a[href=\"/checkout/\"]";
    String ITEM_LINK_CSS = "div:not(.item-thumb) > a[href=\"/shop/bicycle-box/\"]";
}
