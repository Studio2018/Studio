package lu.dmi.icesi.studio;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lu.dmi.icesi.studio.R;

////////////////////////https://www.youtube.com/watch?v=7rtlWMGcnZs

public class ExpandableListAdapterr extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;
    private List<String> _listIds;

    public ExpandableListAdapterr(Context context) {
        this._context = context;
        _listDataHeader = new ArrayList<String>();
        _listIds = new ArrayList<String>();
        _listDataChild = new HashMap<String, List<String>>();
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.filerenglon, null);
        }

        TextView txtListChild = (TextView) convertView.findViewById(R.id.nombrearchivo);
        if(childText.equals("Agregue Un Archivo")){
            ImageView vie = convertView.findViewById(R.id.cambiable);
            vie.setImageResource(R.drawable.add_archivo);
            TextView estado = (TextView) convertView.findViewById(R.id.estadoarchivo);
            estado.setText("");
        } else{
            ImageView vie = convertView.findViewById(R.id.cambiable);
            vie.setImageResource(R.drawable.file);
            TextView estado = (TextView) convertView.findViewById(R.id.estadoarchivo);
            estado.setText("Estado de archivo");
        }
        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.archivorenglon, null);
        }

        TextView lblListHeader = (TextView) convertView.findViewById(R.id.nombrecarpeta);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void addItem(String titulo, List<String> list, String id) {
        _listDataHeader.add(titulo);
        _listIds.add(id);
        _listDataChild.put(titulo, list);
        notifyDataSetChanged();
    }

    public List<String> get_listDataHeader() {
        return _listDataHeader;
    }

    public void set_listDataHeader(List<String> _listDataHeader) {
        this._listDataHeader = _listDataHeader;
    }

    public List<String> get_listIds() {
        return _listIds;
    }

    public void set_listIds(List<String> _listIds) {
        this._listIds = _listIds;
    }

    public HashMap<String, List<String>> get_listDataChild() {
        return _listDataChild;
    }

    public void set_listDataChild(HashMap<String, List<String>> _listDataChild) {
        this._listDataChild = _listDataChild;
    }

    public void reiniciar() {
        _listDataHeader = new ArrayList<String>();
        _listIds = new ArrayList<String>();
        _listDataChild = new HashMap<String, List<String>>();
    }

    public void addact(String s, List<String> listDataChild, List<String> act) {
        _listDataChild.replace(s,listDataChild,act);
        notifyDataSetChanged();
    }
}