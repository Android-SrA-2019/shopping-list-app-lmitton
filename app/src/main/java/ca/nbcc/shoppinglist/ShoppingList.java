package ca.nbcc.shoppinglist;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ShoppingList implements Parcelable{

    private int count;
    private String name;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public ShoppingList(){}

    /**
     * shopping list constructor
     * @param count
     * @param name
     */
    public ShoppingList(int count, String name) {
        this.count = count;
        this.name = name;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(count);
        dest.writeString(name);
    }
    @Override
    public int describeContents() {
        //return 0;
        return hashCode();
    }

    public ShoppingList(Parcel in) {
        count = in.readInt();
        name = in.readString();
    }



    public static final Parcelable.Creator<ShoppingList> CREATOR = new Parcelable.Creator<ShoppingList>() {
        @Override
        public ShoppingList createFromParcel(Parcel source) {
            return new ShoppingList(source);
        }

        @Override
        public ShoppingList[] newArray(int size) {
            return new ShoppingList[size];
        }
    };

    @Override
    public String toString(){
        return this.getCount() + " " + this.getName();
    }
}
