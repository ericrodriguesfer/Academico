import * as Knex from "knex";

export async function up(knex: Knex): Promise<void> {
    return knex.schema.createTableIfNotExists('peoples', (table) => {
        table.increments('id').primary(),
        table.string('identification').notNullable(),
        table.string('name').notNullable(),
        table.string('email').notNullable(),
        table.string('pass').notNullable(),
        table.integer('age').notNullable()
    });
}

export async function down(knex: Knex): Promise<void> {
    return knex.schema.dropTableIfExists('people');
}

