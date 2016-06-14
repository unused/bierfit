class ChangeSizeTypeOfBeers < ActiveRecord::Migration
  def change
    change_column :beers, :size, :string
  end
end
