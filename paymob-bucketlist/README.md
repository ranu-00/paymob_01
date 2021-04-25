paymob-bucketlist: 
This Microservice communicate to main backend whatsapp bank server to show all category items list.  
	
	Request URL and Response example:
	Request input:-
	http://localhost:8088/BucketList/bucket/bucketListItems?itemsInfo=items
	
	Response:-
	{
    "category": [
        {
            "categoryCode": 101,
            "category": "Electronics",
            "items": [
                {
                    "itemCode": 3001,
                    "categoryCode": 101,
                    "name": "AC",
                    "brand": "Voltas",
                    "price": 35000.0
                },
                {
                    "itemCode": 3002,
                    "categoryCode": 101,
                    "name": "Laptop",
                    "brand": "Dell",
                    "price": 49000.0
                },
                {
                    "itemCode": 3003,
                    "categoryCode": 101,
                    "name": "Mobile",
                    "brand": "Samsung",
                    "price": 38000.0
                },
                {
                    "itemCode": 3004,
                    "categoryCode": 101,
                    "name": "Mobile",
                    "brand": "IPhone",
                    "price": 69000.0
                },
                {
                    "itemCode": 3001,
                    "categoryCode": 101,
                    "name": "AC",
                    "brand": "Voltas",
                    "price": 35000.0
                },
                {
                    "itemCode": 3002,
                    "categoryCode": 101,
                    "name": "Laptop",
                    "brand": "Dell",
                    "price": 49000.0
                },
                {
                    "itemCode": 3003,
                    "categoryCode": 101,
                    "name": "Mobile",
                    "brand": "Samsung",
                    "price": 38000.0
                },
                {
                    "itemCode": 3004,
                    "categoryCode": 101,
                    "name": "Mobile",
                    "brand": "IPhone",
                    "price": 69000.0
                },
                {
                    "itemCode": 3001,
                    "categoryCode": 101,
                    "name": "AC",
                    "brand": "Voltas",
                    "price": 35000.0
                },
                {
                    "itemCode": 3002,
                    "categoryCode": 101,
                    "name": "Laptop",
                    "brand": "Dell",
                    "price": 49000.0
                },
                {
                    "itemCode": 3003,
                    "categoryCode": 101,
                    "name": "Mobile",
                    "brand": "Samsung",
                    "price": 38000.0
                },
                {
                    "itemCode": 3004,
                    "categoryCode": 101,
                    "name": "Mobile",
                    "brand": "IPhone",
                    "price": 69000.0
                }
            ]
        },
        {
            "categoryCode": 103,
            "category": "Daily Needs",
            "items": [
                {
                    "itemCode": 3101,
                    "categoryCode": 103,
                    "name": "Bread",
                    "brand": "Patanjali",
                    "price": 30.0
                },
                {
                    "itemCode": 3102,
                    "categoryCode": 103,
                    "name": "Hair Oil",
                    "brand": "Patanjali",
                    "price": 50.0
                },
                {
                    "itemCode": 3103,
                    "categoryCode": 103,
                    "name": "Toothpaste",
                    "brand": "Patanjali",
                    "price": 45.0
                },
                {
                    "itemCode": 3101,
                    "categoryCode": 103,
                    "name": "Bread",
                    "brand": "Patanjali",
                    "price": 30.0
                },
                {
                    "itemCode": 3102,
                    "categoryCode": 103,
                    "name": "Hair Oil",
                    "brand": "Patanjali",
                    "price": 50.0
                },
                {
                    "itemCode": 3103,
                    "categoryCode": 103,
                    "name": "Toothpaste",
                    "brand": "Patanjali",
                    "price": 45.0
                },
                {
                    "itemCode": 3101,
                    "categoryCode": 103,
                    "name": "Bread",
                    "brand": "Patanjali",
                    "price": 30.0
                },
                {
                    "itemCode": 3102,
                    "categoryCode": 103,
                    "name": "Hair Oil",
                    "brand": "Patanjali",
                    "price": 50.0
                },
                {
                    "itemCode": 3103,
                    "categoryCode": 103,
                    "name": "Toothpaste",
                    "brand": "Patanjali",
                    "price": 45.0
                }
            ]
        }
    ]
}
Currently to show case project, only few category 
	along-with their all items list are active which are as:-
		categoryList = Arrays.asList(
						new Category(101, "Electronics"),
						new Category(103, "Daily Needs")
						);
		    itemList = Arrays.asList(
						new Item(3001, 101, "AC", "Voltas", 35000.00),
						new Item(3002, 101, "Laptop", "Dell", 49000.00),
						new Item(3003, 101, "Mobile", "Samsung", 38000.00),
						new Item(3004, 101, "Mobile", "IPhone", 69000.00),
						new Item(3101, 103, "Bread", "Patanjali", 30.00),
						new Item(3102, 103, "Hair Oil", "Patanjali", 50.00),
						new Item(3103, 103, "Toothpaste", "Patanjali", 45.00)
						);
		
		