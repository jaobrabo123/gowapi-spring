create table game(
    id uuid primary key,
    name varchar(100) not null unique,
    description varchar(1000) not null,
    history varchar(3000) not null,
    release_date date not null,
    platform varchar(30) not null
);

INSERT INTO game (id, name, description, history, release_date, platform) VALUES
      ('550e8400-e29b-41d4-a716-446655440000', 'God of War', 'O início da jornada de Kratos contra os deuses do Olimpo.', 'Kratos, um guerreiro espartano, serve aos deuses do Olimpo para se livrar de seus pesadelos. Ele é enviado em uma missão para derrotar Ares, o Deus da Guerra.', '2005-03-22', 'PlayStation 2'),

      ('550e8400-e29b-41d4-a716-446655440001', 'God of War II', 'Kratos busca vingança contra Zeus após ser traído.', 'Após ser morto por Zeus, Kratos é resgatado por Gaia e viaja até as Irmãs do Destino para voltar no tempo e mudar seu futuro.', '2007-03-13', 'PlayStation 2'),

      ('550e8400-e29b-41d4-a716-446655440002', 'God of War: Betrayal', 'Jogo lateral em 2D para dispositivos móveis.', 'Situado entre Ghost of Sparta e God of War II, Kratos é incriminado por um assassinato e persegue um assassino misterioso através da Grécia.', '2007-06-20', 'Java ME'),

      ('550e8400-e29b-41d4-a716-446655440003', 'God of War: Chains of Olympus', 'Prequel que explora os anos de serviço de Kratos aos deuses.', 'Kratos deve encontrar o Deus Sol, Helios, para impedir que o mundo caia na escuridão eterna causada por Morfeu e Persephone.', '2008-03-04', 'PSP'),

      ('550e8400-e29b-41d4-a716-446655440004', 'God of War III', 'O épico encerramento da trilogia grega.', 'Kratos escala o Monte Olimpo com a ajuda dos Titãs para assassinar Zeus e acabar com o reinado dos deuses gregos de uma vez por todas.', '2010-03-16', 'PlayStation 3'),

      ('550e8400-e29b-41d4-a716-446655440005', 'God of War: Ghost of Sparta', 'A busca de Kratos por seu irmão perdido, Deimos.', 'Explora o passado de Kratos e sua ascensão como o novo Deus da Guerra, enquanto ele tenta resgatar seu irmão do domínio de Thanatos.', '2010-11-02', 'PSP'),

      ('550e8400-e29b-41d4-a716-446655440006', 'God of War: Ascension', 'A história de origem sobre como Kratos quebrou seu pacto de sangue.', 'Seis meses após matar sua família, Kratos é preso pelas Fúrias e deve lutar para recuperar sua liberdade e sanidade.', '2013-03-12', 'PlayStation 3'),

      ('550e8400-e29b-41d4-a716-446655440007', 'God of War (2018)', 'Um novo recomeço baseado na mitologia nórdica.', 'Anos após a destruição do Olimpo, Kratos vive como um homem comum no reino dos deuses nórdicos com seu filho Atreus, enfrentando uma jornada pessoal.', '2018-04-20', 'PlayStation 4'),

      ('550e8400-e29b-41d4-a716-446655440008', 'God of War Ragnarök', 'O fim da saga nórdica e o confronto com o destino.', 'Kratos e Atreus devem viajar pelos Nove Reinos em busca de respostas enquanto as forças asgardianas se preparam para a profetizada batalha do fim do mundo.', '2022-11-09', 'PS4/PS5');
