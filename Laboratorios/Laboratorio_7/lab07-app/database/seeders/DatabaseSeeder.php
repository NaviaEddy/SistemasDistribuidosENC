<?php

namespace Database\Seeders;

// use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use App\Models\Participant;

class DatabaseSeeder extends Seeder
{
    /**
     * Seed the application's database.
     */
    public function run(): void
    {
        //\App\Models\User::factory(10)->create();

        Participant::factory()->create([
            'nombre' => 'Juan',
            'apellidos' => 'Perez',
            'email' => 'test@example.com',
            'password' => '123456',
            'rol' => 'admin',
        ]);

        Participant::factory()->create([
            'nombre' => 'Maria',
            'apellidos' => 'Gomez',
            'email' => 'test2@example.com',
            'password' => '456789',
            'rol' => 'user',
        ]);

        $this->call([
            InvoiceSeeder::class,
        ]);
    }
}
