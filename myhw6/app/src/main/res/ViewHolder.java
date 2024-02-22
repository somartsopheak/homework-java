listView = (ListView) findViewById(R.id.list);
        cities = getProvinceName();
//        String longView[] = getLong();

        //adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cities);


        listView.setAdapter(new RowIconAdapter());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // TODO Auto-generated method stub


                String selectedProvice = (String) listView.getItemAtPosition(position);
                Location location = loadLocationsData().get(selectedProvice);

//                Toast.makeText(getApplicationContext(), location.toString(), Toast.LENGTH_LONG).show();
                Bundle provinceData = new Bundle();
                provinceData.putString("provinceName", selectedProvice);
                provinceData.putString("ProvinceLocation", location.toString());

                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), CityDetail.class);
                intent.putExtras(provinceData);
                startActivity(intent);


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        switch (item.getItemId()){
//            case R.id.addnew:
//                showAddNew();
//                return true;
//            case R.id.search:
//                showSearch();
//                return true;
//            case R.id.setting:
//                showsetting();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//    private void showAddNew(){
//        CharSequence text = "This is an Add New";
//        int duration = Toast.LENGTH_LONG;
//        Toast toast = Toast.makeText(getApplicationContext(),text, duration);
//        toast.show();
//    }
//    private void showSearch(){
//        CharSequence text = "This is an Search";
//        int duration = Toast.LENGTH_LONG;
//        Toast toast = Toast.makeText(getApplicationContext(),text, duration);
//        toast.show();
//    }
//    private void showsetting(){
//        CharSequence text = "This is an Settings";
//        int duration = Toast.LENGTH_LONG;
//        Toast toast = Toast.makeText(getApplicationContext(),text, duration);
//        toast.show();
//    }




    private HashMap<String, Location> loadLocationsData (){
        HashMap<String, Location> locations = new HashMap<>();

        locations.put("phnompenh" , new Location(11.5564,104.9282));
        locations.put("sihanoukville", new Location( 10.627543,103.522141));
        locations.put("Kampot", new Location(10.594242,104.164032));
        locations.put("SiemReap", new Location(13.364047,103.860313));
        locations.put("Battambang", new Location(13.028697,102.989616));
        locations.put("KampongCham", new Location(11.99339,105.4635));
        locations.put("KampongChhnang", new Location(12.25,104.66667));
        locations.put("KampongThom", new Location(12.71112,104.88873));
        locations.put("KohKong", new Location(11.61531,102.9838));
        locations.put("Kep", new Location(10.48291,104.31672));
        locations.put("PreyVeng", new Location(11.48682,105.32533));
        locations.put("Takeo", new Location(10.99081,104.78498));
        locations.put("Pursat", new Location(12.53878,103.9192));
        locations.put("Mondolkiri", new Location( 12.45583,107.18811));
        locations.put("StungTreng", new Location(13.52586,105.9683));
        locations.put("SvayRieng", new Location( 11.08785,105.79935));
        locations.put("PreahVihear", new Location(13.80731,104.98046));
        locations.put("Kandal", new Location(11.48333,104.95));
        locations.put("BanteayMeanchey", new Location(13.58588,102.97369));
        locations.put("Ratanakiri", new Location( 13.73939,106.98727));
        locations.put("KampongSpeu", new Location(11.45332,104.52085));
        locations.put("Kratie", new Location(12.48811,106.01879));
        locations.put("Pailin", new Location( 12.84895,102.60928));
        locations.put("OddarMeanchey", new Location(14.18175,103.51761));
        locations.put("TbongKhmum", new Location( 11.8891,105.8760));
        return locations;

    }


    private String[] getProvinceName (){
        String[] provinces = new String[loadLocationsData().size()];
        provinces = loadLocationsData().keySet().toArray(provinces);
        return provinces;
    }

    private String[] getLong (){
        String[] Long = new String[loadLocationsData().size()];
        Long = loadLocationsData().keySet().toArray(Long);
        return Long;
    }

    private static class ViewHolder{
        TextView name;
        ImageView img;
    }

    class RowIconAdapter extends ArrayAdapter<String>{
        public RowIconAdapter(){
            super(MainActivity.this, R.layout.listrow,R.id.row_lable,cities);
        }



        public View getView(int pos, View cView, ViewGroup parent){
            //View row = super.getView(pos,cView,parent);
            //ImageView icon = (ImageView) row.findViewById(R.id.row_icon);
            String city = cities[pos];
            ViewHolder viewHolder = new ViewHolder();


            if(cView==null){

                LayoutInflater inflater = LayoutInflater.from(getContext());
                cView = inflater.inflate(R.layout.listrow,parent,false);
//               viewHolder.name=(TextView) cView.findViewById(R.id.row_lable);
                viewHolder.name = (TextView) cView.findViewById(R.id.row_lable);
                viewHolder.img = (ImageView) cView.findViewById(R.id.row_icon);
                cView.setTag(viewHolder);

            }else {
                viewHolder = (ViewHolder) cView.getTag();
            }

            if(city.startsWith("Phnom Penh")){
                viewHolder.img.setImageResource(R.drawable.phnompenh);
            }else if (city.startsWith(("SiemReap"))) {
                viewHolder.img.setImageResource(R.drawable.siemreap);
            }else {
                viewHolder.img.setImageResource(R.drawable.locations);
            }
            viewHolder.name.setText(city);
            return cView;
        }