class CreateGulps < ActiveRecord::Migration
  def change
    create_table :gulps do |t|
      t.integer :amount_in_ml
      t.datetime :consumed_at
      t.references :beer, index: true, foreign_key: true

      t.timestamps null: false
    end
  end
end
