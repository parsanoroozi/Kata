package keta.kata6;

import java.util.List;

public class PaginationHelper<I> {

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    private List<I> collection;
    private int itemPerPage;
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        if (this.collection.size()%this.itemPerPage==0) return this.collection.size()/this.itemPerPage;
        return this.collection.size()/this.itemPerPage +1;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if(pageIndex < 0) return -1;
        if (this.pageCount() < pageIndex+1) return -1;
        if (this.itemCount() > this.itemPerPage*(pageIndex+1)) return this.itemPerPage;
        else return this.itemCount() - this.itemPerPage*(pageIndex);
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if(itemIndex < 0) return -1;
        if (itemIndex > this.itemCount()-1) return -1;
        return itemIndex/this.itemPerPage;
    }
}
