<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Qualification>
 */
class AcademicFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'ci'=> $this->faker->unique()->randomNumber(8),
            'nombre_completo' => $this->faker->name,
            'titulo' => $this->faker->jobTitle(),
            'fecha_emision' => $this->faker->date(),
        ];
    }
}
