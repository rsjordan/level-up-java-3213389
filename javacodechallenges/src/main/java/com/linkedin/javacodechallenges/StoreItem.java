package com.linkedin.javacodechallenges;

import java.util.Collection;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StoreItem {
  String name;
  double retailPrice;
  double discount;

  public static Optional<StoreItem> findLeastExpensive(Collection<StoreItem> items) {
    Optional<StoreItem> retItem = items.stream().min(StoreItem::compareTo);
  
    return retItem;
  }

  public int compareTo(StoreItem anotherItem) {
    double diffPrice = this.retailPrice * (1 - this.discount)
                        - anotherItem.retailPrice * (1 - anotherItem.discount);
    if (diffPrice > 0) {
      return 1;
    } else if (diffPrice < 0) {
      return -1;
    } else {
      return 0;
    }
  }
  @Override
  public String toString() {
    return "Name: " + name + ", " + "Retail price: " + retailPrice + ", " + "Discount " + discount;
  }
}