import java.util.*;

class Solution {
    public static int[] solution(String[] genres, int[] plays) {
        List<Music> musiclist = new ArrayList<Music>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(int i=0 ; i<genres.length ; i++){
            musiclist.add(new Music(genres[i], plays[i]));
            System.out.println("genres : " + musiclist.get(i).m_genres + ": " + musiclist.get(i).m_playes);
            map.put(genres[i], map.getOrDefault(genres[i], 0));
        }
        System.out.println("----------");
        System.out.println(map);

        for(int i=0 ; i<musiclist.size() ; i++){
            map.put(musiclist.get(i).m_genres, map.getOrDefault(musiclist.get(i).m_genres, 0) + musiclist.get(i).m_playes);
        }

        System.out.println("----------");
        System.out.println(map);
        System.out.println("----------");

        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2){
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });


        System.out.println(list); //내림차순
        System.out.println("----------");

        List<Integer> answer = new ArrayList<Integer>();

        for(int i=0 ; i<list.size() ; i++){
            //List<Music> mlist = new ArrayList<Music>();
            HashMap<Integer, Integer> mmap = new HashMap<Integer, Integer>();

            for(int j=0 ; j<musiclist.size() ; j++){
                if(list.get(i).getKey().equals(musiclist.get(j).m_genres)){
                    mmap.put(j, musiclist.get(j).m_playes);
                    System.out.println(mmap);
                }
            }

            List<Map.Entry<Integer, Integer>> list2 = new ArrayList<Map.Entry<Integer, Integer>>(mmap.entrySet());

            Collections.sort(list2, new Comparator<Map.Entry<Integer, Integer>>(){
                public int compare(Map.Entry<Integer, Integer> obj1, Map.Entry<Integer, Integer> obj2){
                    return obj2.getValue().compareTo(obj1.getValue());
                }
            });

            if(list2.size() < 2){
                answer.add(list2.get(0).getKey());
            } else{
                for(int k=0; k<2 ; k++){
                    answer.add(list2.get(k).getKey());
                }
            }
        }

        System.out.println(answer);

        int[] temp = new int[answer.size()];
        int size=0;
        for(int tmp : answer){
            temp[size++] = tmp;
        }

        for(int i=0; i<temp.length ; i++){
            System.out.print(temp[i] + " ");
        }
        return temp;
    }
}

class Music{
    public String m_genres;
    public int m_playes;

    public Music(String genres, int playes){
        m_genres = genres;
        m_playes = playes;
    }
}