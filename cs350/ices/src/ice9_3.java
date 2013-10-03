for(int i=0; i<3;i++){
	for(int j=0;j<9,j++){
		switch i:
		case 0:
			break;	//<breaks out of switch, not loop
		case 1:
			continue;	//continues for
	}

	System.out.println(10*i+j);
	if(j==4){
		break;
	}
	
	else{
		continue;
	}
}

/*
>0
>1
>2
>3
>4
>20
>21
>22
>23
>24
*/

