package ca.nbcc.shoppinglist;


import java.util.ArrayList;

public class ShoppingList {

    public class ListItem {
        private int count;
        private String name;

        protected int getCount() {
            return count;
        }

        protected void setCount(int count) {
            this.count = count;
        }

        protected String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ListItem() {
        }

        public ListItem(int count, String name) {
            this.count = count;
            this.name = name;
        }

    }

    private ArrayList<ListItem> itemList = new ArrayList();

    public void addItem(String name) {
        boolean itemFound = false;
        if (!name.isEmpty()) {
            for (ListItem item : itemList) {
                if(item.getName().equals(name)){
                    item.setCount(item.getCount() + 1);
                    itemFound = true;
                }
            }
            if (itemFound == false){
                ListItem item = new ListItem(1, name);
                itemList.add(item);
            }

        }
    }

    public ArrayList<ListItem> getItems(){
        return itemList;
    }

}
