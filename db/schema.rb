# encoding: UTF-8
# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20160427183025) do

  create_table "consume_events", force: :cascade do |t|
    t.integer  "analog_reading"
    t.integer  "voltage_reading_in_mv"
    t.integer  "fsr_resistance_in_ohms"
    t.integer  "conductance_in_micromhos"
    t.integer  "force_in_newtons"
    t.datetime "consumed_at"
    t.datetime "created_at",               null: false
    t.datetime "updated_at",               null: false
    t.integer  "user"
  end

end
