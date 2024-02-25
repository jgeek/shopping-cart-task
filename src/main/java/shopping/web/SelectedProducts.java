package shopping.web;

import java.util.List;

public class SelectedProducts {
    private List<Long> ids;

    public SelectedProducts() {
    }

    public SelectedProducts(List<Long> ids) {
        this.ids = ids;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
