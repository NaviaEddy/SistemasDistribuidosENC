<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\Api\v1\InvoiceController;
use App\Http\Controllers\Api\v1\ParticipantController;
use App\Http\Controllers\LoginController;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "api" middleware group. Make something great!
|
*/

// Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
//     return $request->user();
// });


Route::post('login', [LoginController::class, 'login']);


Route::prefix('v1')->group(function () {
    Route::middleware('jwt.verify')->group(function(){
        Route::get('invoice', [InvoiceController::class, 'index']);
        Route::post('invoice', [InvoiceController::class, 'store']);
        Route::get('invoice/{id}', [InvoiceController::class, 'show']);
        Route::put('invoice/{id}', [InvoiceController::class, 'update']);
        Route::patch('invoice/{id}', [InvoiceController::class, 'update']);
        Route::delete('invoice/{id}', [InvoiceController::class, 'destroy']);
    });

    Route::middleware('jwt.verify')->group(function(){
        Route::get('participant', [ParticipantController::class, 'index']);
        Route::post('participant', [ParticipantController::class, 'store']);
        Route::get('participant/{id}', [ParticipantController::class, 'show']);
        Route::put('participant/{id}', [ParticipantController::class, 'update']);
        Route::patch('participant/{id}', [ParticipantController::class, 'update']);
        Route::delete('participant/{id}', [ParticipantController::class, 'destroy']);
    });
    
});