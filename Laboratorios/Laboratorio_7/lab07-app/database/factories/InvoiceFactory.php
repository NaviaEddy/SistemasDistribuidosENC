<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Invoice>
 */
class InvoiceFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'nro' => $this->faker->numberBetween(1, 100),
            'fecha' => $this->faker->date(),
            'cuf' => $this->faker->numberBetween(1, 1000),
            'cufd' => $this->faker->numberBetween(1, 1000),
            'MontoTotal' => $this->faker->numberBetween(1, 1000000),
        ];
    }
}
