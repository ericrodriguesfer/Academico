import * as Knex from "knex";


export async function up(knex: Knex): Promise<void> {
    return knex.schema.createTableIfNotExists('tasks', (table) => {
        table.increments('id').primary(),
        table.string('name').notNullable(),
        table.string('action').notNullable(),
        table.string('people_identification').notNullable(),
        table.foreign('people_identification').references('identification').inTable('people')
    });
}


export async function down(knex: Knex): Promise<void> {
    return knex.schema.dropTableIfExists('tasks');
}

