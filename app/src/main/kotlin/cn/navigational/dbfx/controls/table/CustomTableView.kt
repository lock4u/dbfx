package cn.navigational.dbfx.controls.table


import cn.navigational.dbfx.model.TableSetting
import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.StringProperty
import javafx.collections.ObservableList
import javafx.scene.control.TableView

class CustomTableView : TableView<ObservableList<StringProperty>>() {
    /**
     * table setting property
     */
    private val tableSettingProperty: ObjectProperty<TableSetting>

    init {
        //Default start select cell
        this.selectionModel.isCellSelectionEnabled = true
        this.tableSettingProperty = SimpleObjectProperty(null, "tableSetting",TableSetting())
    }

    /**
     * Get current table setting
     */
    fun getTableSetting(): TableSetting {
        return this.tableSettingProperty.get()
    }

    /**
     * Set current table
     */
    fun setTableSetting(setting: TableSetting) {
        this.tableSettingProperty.set(setting)
    }

    /**
     *Get table setting property
     */
    fun getTableSettingProperty(): ObjectProperty<TableSetting> {
        return this.tableSettingProperty
    }
}