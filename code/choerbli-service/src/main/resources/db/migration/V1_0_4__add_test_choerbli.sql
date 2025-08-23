insert into choerbli (id, state, name, description, end_date, start_date) values
('363301ed-a81d-411f-90d6-5907d30cbbbb', 2, 'Test Assignment', 'Test the Assignment state', '2025-08-24', '2025-08-25'),
('50d9af44-a5e4-4ada-af07-5d71f9579297', 3, 'Test Done', 'Test the Done state', '2025-08-25', '2025-08-27');

insert into ch_user (id, email, name, choerbli_id, points) values
('f69cbb46-5e2d-4af7-bd24-dea0b402ecc7', 'user1@email.com', 'User1', '50d9af44-a5e4-4ada-af07-5d71f9579297', 10),
('5b442ee3-cca4-4fdb-8351-fa5116b95227', 'user2@email.com', 'User2', '363301ed-a81d-411f-90d6-5907d30cbbbb', 0),
('479743fb-76fe-41f3-9743-0d6ab49e8223', 'user3@email.com', 'User3', '50d9af44-a5e4-4ada-af07-5d71f9579297', 8),
('9628c70b-f3c6-4cd2-8f1d-6a3ab8460287', 'user4@email.com', 'User4', '363301ed-a81d-411f-90d6-5907d30cbbbb', 0),
('66dcb61c-78ce-41f7-a92b-bb7e086294f3', 'user5@email.com', 'User5', '50d9af44-a5e4-4ada-af07-5d71f9579297', 11);

insert into item_description (id, category_id, name) values
('7c4888bb-3db6-489e-a3bd-6aa351a7f26e', 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Test Drink 1'),
('0d2c9ceb-873b-4b21-abed-ad73fc318f86', 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Test Drink 2'),
('1b4dc4d4-bd3a-4dd4-a9e2-dcfbfc315158', 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Test Drink 3'),
('88279800-9fcf-4e7b-b4f8-419b872eaefc', 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Test Drink 4'),
('57f31635-e4c8-4772-be8a-da5c0b47cdd6', 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Test Drink 5'),
('b648fd20-2632-4716-9542-b75963725187', 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Test Drink 6'),
('c7e25a5c-0f7a-4615-8ade-20a3e9df4b30', 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Test Drink 7'),
('248c051f-2c40-4991-b26b-b4751742769c', 'CBAA920A-E7DE-45C1-9DC1-D004B2731F22', 'Test Drink 8');

insert into item (id, choerbli_id, item_description_id, user_id, points, price) values
('dbbe2a35-f9c2-4bbb-b891-bfbe149a8311', '363301ed-a81d-411f-90d6-5907d30cbbbb', '7c4888bb-3db6-489e-a3bd-6aa351a7f26e', null, 2, 0.0),
('1258365e-e3a3-4b41-9b9b-4c95fb3e6818', '363301ed-a81d-411f-90d6-5907d30cbbbb', '0d2c9ceb-873b-4b21-abed-ad73fc318f86', null, 2, 0.0),
('3cffba52-b4a5-4523-9b30-c834dc010726', '363301ed-a81d-411f-90d6-5907d30cbbbb', '1b4dc4d4-bd3a-4dd4-a9e2-dcfbfc315158', null, 2, 0.0),
('34ac520b-7975-47be-af1d-c79cb6c11910', '363301ed-a81d-411f-90d6-5907d30cbbbb', '88279800-9fcf-4e7b-b4f8-419b872eaefc', null, 2, 0.0),
('1b765a3c-b482-4ea1-9782-7334ea334a7a', '50d9af44-a5e4-4ada-af07-5d71f9579297', '57f31635-e4c8-4772-be8a-da5c0b47cdd6', 'f69cbb46-5e2d-4af7-bd24-dea0b402ecc7', 4, 30.0),
('4d1dd654-bc97-4f6c-a253-9dba4b14ab6a', '50d9af44-a5e4-4ada-af07-5d71f9579297', 'b648fd20-2632-4716-9542-b75963725187', 'f69cbb46-5e2d-4af7-bd24-dea0b402ecc7', 6, 25.0),
('b979ccdc-efcd-44fa-ab67-90bd79d26102', '50d9af44-a5e4-4ada-af07-5d71f9579297', 'c7e25a5c-0f7a-4615-8ade-20a3e9df4b30', '479743fb-76fe-41f3-9743-0d6ab49e8223', 8, 70.0),
('b93fe7df-ca0a-48a3-afea-8f97fad08eea', '50d9af44-a5e4-4ada-af07-5d71f9579297', '248c051f-2c40-4991-b26b-b4751742769c', '66dcb61c-78ce-41f7-a92b-bb7e086294f3', 11, 11.0);




