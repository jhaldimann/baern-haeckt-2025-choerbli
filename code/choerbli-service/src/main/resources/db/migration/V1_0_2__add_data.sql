-- Categories
insert into category (id, name) values
('CBAA920A-E7DE-45C1-9DC1-D004B2731F22','Drinks'),
('DF5192F3-B999-4DEA-9580-330D2EE25897','Snacks'),
('2D09903B-B55B-44FC-A397-58E2F9E7B995','Food');

-- Drinks
insert into item_description (id, category_id, name) values
(gen_random_uuid(), 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Beer'),
(gen_random_uuid(), 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Red Wine'),
(gen_random_uuid(), 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'White Wine'),
(gen_random_uuid(), 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Rosé Wine'),
(gen_random_uuid(), 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Whiskey'),
(gen_random_uuid(), 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Vodka'),
(gen_random_uuid(), 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Gin & Tonic'),
(gen_random_uuid(), 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Rum & Cola'),
(gen_random_uuid(), 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Water'),
(gen_random_uuid(), 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Sparkling Water'),
(gen_random_uuid(), 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Coca Cola'),
(gen_random_uuid(), 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Pepsi'),
(gen_random_uuid(), 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Fanta'),
(gen_random_uuid(), 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Sprite'),
(gen_random_uuid(), 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Ice Tea'),
(gen_random_uuid(), 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Red Bull'),
(gen_random_uuid(), 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Monster Energy'),
(gen_random_uuid(), 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Apple Juice'),
(gen_random_uuid(), 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Orange Juice'),
(gen_random_uuid(), 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Lemonade');

-- Snacks
insert into item_description (id, category_id, name) values
(gen_random_uuid(), 'DF5192F3-B999-4DEA-9580-330D2EE25897', 'Paprika Chips'),
(gen_random_uuid(), 'DF5192F3-B999-4DEA-9580-330D2EE25897', 'Salted Chips'),
(gen_random_uuid(), 'DF5192F3-B999-4DEA-9580-330D2EE25897', 'Nachos with Dip'),
(gen_random_uuid(), 'DF5192F3-B999-4DEA-9580-330D2EE25897', 'Trail Mix'),
(gen_random_uuid(), 'DF5192F3-B999-4DEA-9580-330D2EE25897', 'Mixed Nuts'),
(gen_random_uuid(), 'DF5192F3-B999-4DEA-9580-330D2EE25897', 'Popcorn'),
(gen_random_uuid(), 'DF5192F3-B999-4DEA-9580-330D2EE25897', 'Chocolate'),
(gen_random_uuid(), 'DF5192F3-B999-4DEA-9580-330D2EE25897', 'Gummy Bears'),
(gen_random_uuid(), 'DF5192F3-B999-4DEA-9580-330D2EE25897', 'Cookies'),
(gen_random_uuid(), 'DF5192F3-B999-4DEA-9580-330D2EE25897', 'Brownie Bites'),
(gen_random_uuid(), 'DF5192F3-B999-4DEA-9580-330D2EE25897', 'Cheese Cubes & Crackers'),
(gen_random_uuid(), 'DF5192F3-B999-4DEA-9580-330D2EE25897', 'Mini Pretzels'),
(gen_random_uuid(), 'DF5192F3-B999-4DEA-9580-330D2EE25897', 'Donut Holes'),
(gen_random_uuid(), 'DF5192F3-B999-4DEA-9580-330D2EE25897', 'Granola Bars'),
(gen_random_uuid(), 'DF5192F3-B999-4DEA-9580-330D2EE25897', 'Veggie Sticks & Dip');

-- Food
insert into item_description (id, category_id, name) values
(gen_random_uuid(), '2D09903B-B55B-44FC-A397-58E2F9E7B995', 'Pizza'),
(gen_random_uuid(), '2D09903B-B55B-44FC-A397-58E2F9E7B995', 'Burgers'),
(gen_random_uuid(), '2D09903B-B55B-44FC-A397-58E2F9E7B995', 'Hot Dogs'),
(gen_random_uuid(), '2D09903B-B55B-44FC-A397-58E2F9E7B995', 'Sandwiches'),
(gen_random_uuid(), '2D09903B-B55B-44FC-A397-58E2F9E7B995', 'Wraps'),
(gen_random_uuid(), '2D09903B-B55B-44FC-A397-58E2F9E7B995', 'Quesadillas'),
(gen_random_uuid(), '2D09903B-B55B-44FC-A397-58E2F9E7B995', 'Tacos'),
(gen_random_uuid(), '2D09903B-B55B-44FC-A397-58E2F9E7B995', 'Chicken Wings'),
(gen_random_uuid(), '2D09903B-B55B-44FC-A397-58E2F9E7B995', 'BBQ Ribs'),
(gen_random_uuid(), '2D09903B-B55B-44FC-A397-58E2F9E7B995', 'Salad Bowl'),
(gen_random_uuid(), '2D09903B-B55B-44FC-A397-58E2F9E7B995', 'Sushi Platter'),
(gen_random_uuid(), '2D09903B-B55B-44FC-A397-58E2F9E7B995', 'Spring Rolls'),
(gen_random_uuid(), '2D09903B-B55B-44FC-A397-58E2F9E7B995', 'Cheese Fondue'),
(gen_random_uuid(), '2D09903B-B55B-44FC-A397-58E2F9E7B995', 'Grilled Vegetables'),
(gen_random_uuid(), '2D09903B-B55B-44FC-A397-58E2F9E7B995', 'Pasta Salad');
