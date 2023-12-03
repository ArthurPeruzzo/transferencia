create table if not exists usuario (
    id_usuario serial primary key,
    nome_completo varchar(60) not null,
    identificacao varchar(14) unique not null,
    email varchar(255) unique not null,
    senha varchar(255) not null
);

create table if not exists usuario_comum (
    id_usuario_comum serial primary key,
    id_usuario integer not null references usuario(id_usuario)
);

create table if not exists usuario_lojista (
    id_usuario_lojista serial primary key,
    id_usuario integer not null references usuario(id_usuario)
);
