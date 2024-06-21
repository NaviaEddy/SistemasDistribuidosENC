<?php

namespace Database\Seeders;

use App\Models\Wheater;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class WheaterSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        Wheater::factory(20)->create();
    }
}
