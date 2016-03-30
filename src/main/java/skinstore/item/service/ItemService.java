package skinstore.item.service;

import skinstore.item.database.DatabaseClass;
import skinstore.item.model.Item;
import java.util.*;

public class ItemService {
	
	private Map<Long, Item> items = DatabaseClass.getMessages();
	public ItemService() {
		items.put(1L, new Item(62, "Luminous Silk Foundation", "foundation", 1L, 1, "Armani", 20, "images/0001.jpg", "This award-winning foundation is formulated with micro-fil technology, producing a low-density product that pairs high-impact pigments with weightless texture. Inspired by the silk shantung worn by kings and emperors, this foundation glides seamlessly onto the skin leaving a finish that’s reminiscent of charmeuse silk. ", 201));
		items.put(2L, new Item(39, "Rainforest of the Sea Water Foundation Broad Spectrum SPF 15", "foundation", 2L, 1, "tarte", 15, "images/0002.jpg", "A lightweight, full-coverage hydrating foundation infused with tarte's Rainforest of the Sea™ complex and non-chemical SPF 15 sunscreen. ", 100000));
		items.put(3L, new Item(50,"Diorskin Forever Perfect Makeup Broad Spectrum 35","foundation", 3L, 1, "Dior", 30, "images/0003.jpg","A non-oily texture, ultra-fusional, fluid foundation that delivers perfectly even color correction. ", 2000  ));
		items.put(4L, new Item(35,"Lock it Foundation","foundation", 4L, 1, "Dior", 30, "images/0004.jpg","A non-oily texture, ultra-fusional, fluid foundation that delivers perfectly even color correction. ", 2000  ));
		items.put(5L, new Item(50,"Ultra HD Invisible Cover Foundation","foundation", 5L, 1, "Dior", 30, "images/0005.jpg","A non-oily texture, ultra-fusional, fluid foundation that delivers perfectly even color correction. ", 2000  ));
	}
	public List<Item> getAllItems(){
		return new ArrayList<Item>(items.values());
	}
	
	public Map<Long, Item> getItems(){
		return items;
	}

}
