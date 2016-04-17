class CreateConsumeEvents < ActiveRecord::Migration
  def change
    create_table :consume_events do |t|
      t.integer :analog_reading
      t.integer :voltage_reading_in_mv
      t.integer :fsr_resistance_in_ohms
      t.integer :conductance_in_micromhos
      t.integer :force_in_newtons
      t.datetime :consumed_at

      t.timestamps null: false
    end
  end
end
